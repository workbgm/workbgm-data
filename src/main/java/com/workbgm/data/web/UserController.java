package com.workbgm.data.web;
import com.workbgm.gen.core.Result;
import com.workbgm.gen.core.ResultGenerator;
import com.workbgm.data.model.User;
import com.workbgm.data.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户管理接口
* Created by workbgm on 2017/08/12.
*/
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 增加用户
     * @param user 用户对象
     * @return
     */
    @ApiOperation(value="增加用户", notes="")
    @PostMapping("/add")
    public Result add(User user) {
        userService.save(user);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 删除用户
     * @param id  ID
     * @return
     */
    @ApiOperation(value="删除用户", notes="")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        userService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 更新用户
     * @param user  用户对象
     * @return
     */
    @ApiOperation(value="用户对象", notes="")
    @PostMapping("/update")
    public Result update(User user) {
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 获取用户详情
     * @param id  ID
     * @return
     */
    @ApiOperation(value="获取用户详情", notes="")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        User user = userService.findById(id);
        return ResultGenerator.genSuccessResult(user);
    }

    /**
     * 获取用户列表
     * @param page  页码
     * @param size  每页显示的个数
     * @return
     */
    @ApiOperation(value="获取用户列表", notes="")
    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
