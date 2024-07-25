package dev.danvega.fragments.cart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
@CrossOrigin
public class ShoppingCartController {

    private static final Logger log = LoggerFactory.getLogger(ShoppingCartController.class);
    private final CartService cartService;

    public ShoppingCartController(CartService cartRepository) {
        this.cartService = cartRepository;
    }

    @GetMapping("")
    public String cart(Model model) {
        model.addAttribute("products", cartService.findAll());
        model.addAttribute("orderSubTotal", cartService.getOrderSubTotal());
        model.addAttribute("orderTotal", cartService.getOrderTotal());
        return "cart";
    }

    @PostMapping("/update/{id}")
    public Collection<ModelAndView> updateCart(@PathVariable Integer id, Model model) {
        cartService.remove(id);
        return List.of(
                new ModelAndView("order-summary :: orderSummaryFragment",
                        Map.of("orderSubTotal",cartService.getOrderSubTotal(),"orderTotal",cartService.getOrderTotal())),
                new ModelAndView("products :: productsFragment", Map.of("products", cartService.findAll()))
        );
    }

}
