package com.cts.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.ecart.dao.ProductDao;
import com.cts.ecart.entity.Product;
import com.cts.ecart.entity.Stock;
@Service
public class ProductServiceImpl implements ProductService, ProductInventoryUpdate {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Product findById(int productId) {
		return productDao.findById(productId).orElse(null);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public List<Product> findByProductTitle(String productTitle) {
		// TODO Auto-generated method stub
		return productDao.findByProductTitleLike(productTitle);
	}

	@Override
	public List<Product> findByPriceRange(double startRange, double endRange) {
		// TODO Auto-generated method stub
		return productDao.findByPrice_ProductPriceBetween(startRange, endRange);
	}

	@Override
	public List<Product> findByPriceGreater(double price) {
		// TODO Auto-generated method stub
		return productDao.findByPrice_ProductPriceGreaterThanEqual(price);
	}

	@Override
	public List<Product> findBypriceLesser(double price) {
		// TODO Auto-generated method stub
		return productDao.findByPrice_ProductPriceLessThanEqual(price);
	}

	@Override
	public List<Product> findByBrandTitle(String brandTitle) {
		// TODO Auto-generated method stub
		return productDao.findByBrand_BrandTitleLike(brandTitle);
	}

	@Override
	public List<Product> findByBrandId(int brandId) {
		// TODO Auto-generated method stub
		return productDao.findByBrand_BrandId(brandId);
	}

	@Override
	public List<Product> findByCategoryTitle(String categoryTitle) {
		// TODO Auto-generated method stub
		return productDao.findByCategory_CategoryTitleLike(categoryTitle);
	}

	@Override
	public List<Product> findByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		return productDao.findByCategory_CategoryId(categoryId);
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.save(product);
	}

	@Override
	public List<Product> saveAllProducts(List<Product> products) {
		// TODO Auto-generated method stub
		return productDao.saveAll(products);
	}

	@Override
	public void deleteProductById(int productId) {
		productDao.deleteById(productId);
		
	}

	@Override
	public void deleteProduct(Product product) {
		productDao.delete(product);	
	}
	
	
	
	//update inventory information 
	@Override
	public Product updateInventory(int productId,int quantity) {
		Product product = productDao.findById(productId).orElse(null);
		if(product!=null) {
			
			Stock stock = product.getStock();
			stock.setStock(stock.getStock()-quantity);
			product.setStock(stock);
			productDao.save(product);
			return product;
			
		}
		return null;
	}
	
	
	
	
	
	
	
	
	

}
