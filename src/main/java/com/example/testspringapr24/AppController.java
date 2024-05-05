package com.example.testspringapr24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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


    AppController( CredentialRepository credentialRepository,
                   UserdetailRepository userdetailRepository,
                   WalletRepository walletRepository,
                   UsernamewalletlinkRepository usernamewalletlinkRepository,
                   UsertypelinkRepository usertypelinkRepository,
                   ProductofferRepository productofferRepository,
                   ProductRepository productRepository)

    {
        this.credentialRepository = credentialRepository;
        this.userdetailRepository = userdetailRepository;
        this.walletRepository = walletRepository;
        this.usernamewalletlinkRepository = usernamewalletlinkRepository;
        this.usertypelinkRepository = usertypelinkRepository;
        this.productofferRepository = productofferRepository;
        this.productRepository = productRepository;
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
}
