package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProducService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProductService productService = new ProducService();
    @GetMapping("")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("products",productService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("/create");
        Product product = new Product();
        product.setId(ProducService.id++);
        modelAndView.addObject("product",product );
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(Product product,RedirectAttributes redirect){
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        productService.save(product);
        redirect.addFlashAttribute("success","create Success!");
        return modelAndView;
    }@GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/edit");
       Product product = productService.findById(id);
       modelAndView.addObject("product",product);
       return modelAndView;
    }
    @PostMapping("/update")
    public ModelAndView update(Product product, RedirectAttributes redirect){
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        productService.update(product.getId(),product);
        redirect.addFlashAttribute("success","edit Success!");
        return modelAndView;
    }
    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/delete");
        Product product = productService.findById(id);
        modelAndView.addObject("product",product);
        return modelAndView;
    }
    @PostMapping ("/delete")
    public ModelAndView remove(Product product, RedirectAttributes redirect){
        ModelAndView modelAndView = new ModelAndView("redirect:/product");
        productService.remove(product.getId());
        redirect.addFlashAttribute("success","delete Success!");
        return modelAndView;
    }
    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }
    @GetMapping("search")
    public ModelAndView view(@RequestParam String name) {
        ModelAndView modelAndView = new ModelAndView("/search");
        modelAndView.addObject("product", productService.findByName(name));
        return modelAndView;
    }
}
