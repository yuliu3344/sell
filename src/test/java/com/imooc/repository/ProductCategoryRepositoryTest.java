package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 廖师兄
 * 2017-05-07 14:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void upTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(1);
        productCategory.setCategoryType(2);
        productCategory.setCategoryName("24355");
        repository.save(productCategory);
        System.out.println(productCategory.toString());
    }


    @Test //@Transactional  //测试成功后直接删除
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("男生最爱", 4);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
//        Assert.assertNotEquals(null, result);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(4,5);

        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }

//    @Test
//    public void updateTest() {
////        ProductCategory productCategory = repository.findOne(4);
////        productCategory.setCategoryName("男生最爱1");
//        ProductCategory productCategory = new ProductCategory("男生最爱", 4);
//        ProductCategory result = repository.save(productCategory);
//        Assert.assertEquals(productCategory, result);
//    }
}