package com.example.testspringapr24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
public class AppController {

   // @Autowired
    //CredentialRepository credentialRepository;

    CredentialRepository credentialRepository;
    UserdetailRepository userdetailRepository;
    WalletRepository walletRepository;
    UsernamewalletlinkRepository usernamewalletlinkRepository;
    UsertypelinkRepository usertypelinkRepository;
    ProductofferRepository productofferRepository;
    ProductRepository productRepository;
    ProductofferstatusRepository productofferstatusRepository;
    OrderRepository orderRepository;


    AppController( CredentialRepository credentialRepository,
                   UserdetailRepository userdetailRepository,
                   WalletRepository walletRepository,
                   UsernamewalletlinkRepository usernamewalletlinkRepository,
                   UsertypelinkRepository usertypelinkRepository,
                   ProductofferRepository productofferRepository,
                   ProductRepository productRepository,
                   ProductofferstatusRepository productofferstatusRepository,
                   OrderRepository orderRepository)

    {
        this.credentialRepository = credentialRepository;
        this.userdetailRepository = userdetailRepository;
        this.walletRepository = walletRepository;
        this.usernamewalletlinkRepository = usernamewalletlinkRepository;
        this.usertypelinkRepository = usertypelinkRepository;
        this.productofferRepository = productofferRepository;
        this.productRepository = productRepository;
        this.productofferstatusRepository = productofferstatusRepository;
        this.orderRepository = orderRepository;
    }

    @PostMapping("signup")
    public ResponseEntity<String> signup(@RequestBody Credential credential){
        credentialRepository.save(credential);
        return ResponseEntity.ok("New user signup");
    }

    //    @GetMapping("login")
//    public ResponseEntity<String> login()
//    {
//        return ResponseEntity.ok("ALL OK");
//    }

    @PostMapping("save/user/details")
    public ResponseEntity<Userdetail>  saveUserDetails(@RequestBody Userdetail userdetail,
                                                       @Autowired Wallet wallet,
                                                       @Autowired Usernamewalletlink usernamewalletlink
    ) {

        userdetailRepository.save(userdetail);
        wallet.setWalletid(String.valueOf(UUID.randomUUID()));
        wallet.setBalance(5000000);
        wallet.setState("valid");
        walletRepository.save(wallet);

        usernamewalletlink.setWalletid(wallet.getWalletid());
        usernamewalletlink.setUsername(userdetail.getUsername());
        usernamewalletlinkRepository.save(usernamewalletlink);

        return ResponseEntity.ok(userdetail);
    }

    @PostMapping("save/user/type/{username}/{usertype}")
    public ResponseEntity<Usertypelink>  saveUserType(@PathVariable String username,
                                                      @PathVariable String usertype,
                                                      Usertypelink usertypelink)
    {
        usertypelink.setLinkid(String.valueOf(UUID.randomUUID()));
        usertypelink.setUsername(username);
        usertypelink.setType(usertype);

        usertypelinkRepository.save(usertypelink);

        return ResponseEntity.ok(usertypelink);
    }

    @PostMapping("save/product/offer")
    public ResponseEntity<Productoffer> createOffer(@RequestBody Productoffer offer)
    {
        offer.setId(String.valueOf(UUID.randomUUID()));
        productofferRepository.save(offer);
        return ResponseEntity.ok(offer);
    }

    @GetMapping("get/all/products")
    public ResponseEntity<List<Product>> getAllProducts()
    {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping("get/user/details/{username}")
    public ResponseEntity<Userdetail> getUserDetails(@PathVariable String username)
    {
        return ResponseEntity.ok(userdetailRepository.findById(username).get());
    }

    @GetMapping("get/all/offers/{sellername}")
    public ResponseEntity<List<Productoffer>> getAllOffersBySellername(@PathVariable String sellername)
    {
        return ResponseEntity.ok(productofferRepository.findBySellername(sellername));
    }


    @GetMapping("get/all/offers/open") //get all offers from all sellers. This is a bad practice. We should have a separate endpoint for this. But for simplicity, I am leaving it as it is.  We can change it later.  We can also add a filter to this endpoint.  For example, we can add a filter to get offers for a particular seller.  We can also add a filter to get offers for a particular product.  We can also add a filter to get offers for a particular product and seller.  We can also add a filter to get offers for a particular product and seller and a particular state.  We can also add a filter to get offers for a particular product and seller and a particular state and a particular country.  We can also add a filter to get offers for a particular product and seller and a particular state and a particular country and a particular currency.  We can also add a filter to get offers for a particular product and seller and a particular state and a particular country and a particular currency and a particular price range.  We can also add a filter to get offers for a particular product and seller and a particular state and a particular country and a particular currency and a particular price range and
    public ResponseEntity<List<Productoffer>> getAllOpenOffers()
    {
        List<Productofferstatus> productofferstatuses = productofferstatusRepository.findByStatus("OPEN");
        List<Productoffer> productoffers = productofferstatuses.stream().map(status -> productofferRepository.findById(status.getOfferid()).get()).collect(Collectors.toList());
        return ResponseEntity.ok(productoffers);
    }

    @PostMapping("save/order")
    public ResponseEntity<Order> createOrder(@RequestBody Order order)
    {
        order.setOrderid(String.valueOf(UUID.randomUUID()));
        orderRepository.save(order);
        return ResponseEntity.ok(order);
    }
}
