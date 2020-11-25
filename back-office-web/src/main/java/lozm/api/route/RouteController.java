package lozm.api.route;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("/pages")
@RequiredArgsConstructor
public class RouteController {


    @GetMapping("/home")
    public String home(ModelMap modelMap) {
        return "pages/home";
    }

    @GetMapping("/manage/board")
    public String manageBoard(ModelMap modelMap) {
        setBoardInfo(modelMap);

        return "pages/board/board";
    }

    @GetMapping("/manage/board/{boardId}")
    public String manageBoardDetail(ModelMap modelMap, @PathVariable(value = "boardId") Long boardId) {
//        setBoardInfo(modelMap);
//
//        List<ContentType> commentTypeList = Arrays.asList(ContentType.values());
//        modelMap.addAttribute("commentTypeList", commentTypeList);

        return "pages/board/boardDetail";
    }

    private void setBoardInfo(ModelMap modelMap) {
//        List<BoardType> boardTypeList = Arrays.asList(BoardType.values());
//        modelMap.addAttribute("boardTypeList", boardTypeList);
//
//        List<ContentType> contentTypeList = Arrays.asList(ContentType.values());
//        modelMap.addAttribute("contentTypeList", contentTypeList);
    }

    @GetMapping("/manage/store")
    public String manageStore(ModelMap modelMap) {
        return "pages/store/store";
    }

    @GetMapping("/manage/store/{storeId}")
    public String manageItem(ModelMap modelMap, @PathVariable(value = "storeId") Long storeId) {
        return "pages/store/storeDetail";
    }

    @GetMapping("/manage/item")
    public String manageItem(ModelMap modelMap) {
        return "pages/item/item";
    }

    @GetMapping("/manage/coupon")
    public String manageCoupon(ModelMap modelMap) {
        return "pages/coupon/coupon";
    }

    @GetMapping("/manage/coupon/{couponId}")
    public String manageCoupon(ModelMap modelMap, @PathVariable(value = "couponId") Long couponId) {
        return "pages/coupon/couponDetail";
    }

    @GetMapping("/manage/delivery")
    public String manageDelivery(ModelMap modelMap) {
        return "pages/delivery/delivery";
    }

    @GetMapping("/manage/orders")
    public String manageOrders(ModelMap modelMap) {
        return "pages/orders/orders";
    }

    @GetMapping("/setting/user")
    public String settingUser(ModelMap modelMap) {
        return "pages/user/user";
    }

    @GetMapping("/sign/in")
    public String signIn(ModelMap modelMap) {
        return "pages/sign/signIn";
    }

}