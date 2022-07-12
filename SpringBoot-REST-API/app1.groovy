


@RestController
class FirstApp {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        System.out.println("Request to the spring REST APP");

        "Hello from the spring REST app"
    }

    @RequestMapping("/spring")
    @ResponseBody
    String spring(){
        println("Request to the '/spring' endpoint");
        "Hello from the '/spring' endpoint"
    }

    
}