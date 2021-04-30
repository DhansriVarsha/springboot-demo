package com.deloitte.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.deloitte.dto.ProductTO;
import com.deloitte.services.ProductService;

/**
 * Product controller.
 */
@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    
    /**
     * Home Screen.
     * 
     * @return
     */
    @RequestMapping("/")
    public String homeScreen() {
        return "index";
    }

    /**
     * List all products.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String listProducts(Model model) {
        model.addAttribute("products", productService.listAllProducts());
        //System.out.println("Returning rpoducts:");
        return "products";
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("product/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "productshow";
    }

    /**
     * Edit a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("product/edit/{id}")
    public String editProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "productform";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("product/new")
    public String addProduct(Model model) {
        model.addAttribute("product", new ProductTO());
        return "productform";
    }

    /**
     * Save product to database.
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(ProductTO product) {
    	ProductTO savedProduct = productService.saveProduct(product);
        return "redirect:/product/" + savedProduct.getId();
    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("product/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

}
