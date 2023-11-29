package com.ust.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.spring.model.Product;
import com.ust.spring.model.ProductRepository;

@RestController
@RequestMapping("product")  //so that we can access localhostport8080/product
public class ProductController{
	@Autowired
	private ProductRepository pr;
	
	@GetMapping  // to get all entries
	public List<Product> retrieveAllEmployees(){
		return pr.findAll();
	}
	
	@GetMapping("/{id}") // select according to given id check eg:localhost8080/1 checks for id 1 and if there is id 1 returns the entry in product having id=1 ;
	public Product findProductById(@PathVariable("id") Integer id)// path variable call acording to id only no need to call whole body
	{
		Product pdt=null;
		Optional<Product> temp = pr.findById(id);
		if(temp.isPresent())
			pdt=temp.get();
		return pdt;
	}
	
	@PostMapping
	public Product addProduct(@RequestBody Product product)
	{
		return pr.save(product);
	}
	
	@PutMapping
    public Product updateProduct(@RequestBody Product product) {
        Product pdt=findProductById(product.getId());
        if(pdt!=null) {
            pdt=product;
         pr.save(pdt);
        }
    return pdt;
    }
	
	@DeleteMapping("/{id}")
	public Product deleteProduct(@PathVariable("id")Integer id)
	{
	 Product pdt =findProductById(id);
	 if(pdt!=null)
	 {
		 pr.delete(pdt);
	 }
	 return pdt;
	}
	
}
