package lozm.api.route;

import lombok.RequiredArgsConstructor;
import me.lozm.object.code.BoardType;
import me.lozm.object.code.ContentType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

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
        setBoardInfo(modelMap);

        List<ContentType> commentTypeList = Arrays.asList(ContentType.values());
        modelMap.addAttribute("commentTypeList", commentTypeList);

        return "pages/board/boardDetail";
    }

    private void setBoardInfo(ModelMap modelMap) {
        List<BoardType> boardTypeList = Arrays.asList(BoardType.values());
        modelMap.addAttribute("boardTypeList", boardTypeList);

        List<ContentType> contentTypeList = Arrays.asList(ContentType.values());
        modelMap.addAttribute("contentTypeList", contentTypeList);
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