package com.windvalley.sell.controller;

import com.windvalley.sell.entity.ProductCategory;
import com.windvalley.sell.entity.ProductInfo;
import com.windvalley.sell.service.impl.CategoryServiceImpl;
import com.windvalley.sell.service.impl.ProductServiceImpl;
import com.windvalley.sell.utils.ResultVOUtil;
import com.windvalley.sell.vo.ProductInfoVO;
import com.windvalley.sell.vo.ProductVO;
import com.windvalley.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    ProductServiceImpl productService;

    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping("list")
    public ResultVO list(){
        //1. 查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2. 查询类目
        List<Integer> categoryTypeList = getCategoryTypeFromProductList(productInfoList);
        List<ProductCategory> productCategoryList = categoryService.findByTypeIn(categoryTypeList);

        //3. 数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory: productCategoryList){
            ProductVO productVO = getProductVOByCategory(productCategory, productInfoList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }

    private List<ProductInfoVO> getProductVOListByCategoryType(Integer type, List<ProductInfo> productInfoList) {
        List<ProductInfoVO> productInfoVOList = new ArrayList<>();
        for (ProductInfo productInfo: productInfoList){
            if (productInfo.getCategoryType() == type){
                ProductInfoVO productInfoVO = new ProductInfoVO();
                BeanUtils.copyProperties(productInfo, productInfoVO);
                productInfoVOList.add(productInfoVO);
            }
        }
        return productInfoVOList;
    }

    private ProductVO getProductVOByCategory(ProductCategory productCategory, List<ProductInfo> productInfoList) {
        ProductVO productVO = new ProductVO();
        productVO.setCategoryType(productCategory.getType());
        productVO.setCategoryName(productCategory.getName());
        List<ProductInfoVO> productInfoVOList = getProductVOListByCategoryType(productCategory.getType(), productInfoList);
        productVO.setProductInfoVOList(productInfoVOList);
        return productVO;
    }

    private List<Integer> getCategoryTypeFromProductList(List<ProductInfo> productInfoList) {
        List<Integer> categoryTypeList = new ArrayList<>();
        for (ProductInfo productInfo: productInfoList){
            categoryTypeList.add(productInfo.getCategoryType());
        }
        return categoryTypeList;
    }
}
