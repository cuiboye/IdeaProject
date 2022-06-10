package com.example.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/danyuan")
public class UserEntityController {
    @Autowired
    private UserEntityService userEntityService;

    /**
     * 通过id查找用户
     *
     * @param userid
     * @return
     */
    @RequestMapping("/findByParentCode")
    @ResponseBody
    public List<UserEntity> findByParentCode(@RequestParam("userid") Integer userid) {
        return userEntityService.findByUserid(userid);
    }

    /**
     * 获取全部的用户数据
     *
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll() {
        List<UserEntity> list = userEntityService.findAll();
        BaseEntity<Object> baseEntity = new BaseEntity<>();
        baseEntity.setStates(200);
        baseEntity.setMsg("请求成功");

        BaseEntity.Result result = new BaseEntity.Result();
        result.setUserList(list);

        baseEntity.setResult(result);
        return JSONObject.toJSONString(baseEntity);
    }


    /**
     * 获取全部的用户数据-测试上拉加载下拉刷新
     *
     * @return
     */
    @RequestMapping("/findAllFresh")
    @ResponseBody
    public String findAllFresh(@RequestParam("pageIndex") int pageIndex) {

        BaseEntity<Object> baseEntity = new BaseEntity<>();
        baseEntity.setStates(200);
        baseEntity.setMsg("请求成功");

        List<UserEntity> list = new ArrayList<>();

        if(pageIndex == 1){
            for(int i=0;i<5;i++){
                UserEntity userEntity = new UserEntity();
                userEntity.setUsername("数据"+i);
                list.add(userEntity);
            }
        } else if (pageIndex == 2) {
            for (int i = 5; i < 10; i++) {
                UserEntity userEntity = new UserEntity();
                userEntity.setUsername("数据" + i);
                list.add(userEntity);
            }
        }else if (pageIndex == 3) {
            for (int i = 11; i < 15; i++) {
                UserEntity userEntity = new UserEntity();
                userEntity.setUsername("数据" + i);
                list.add(userEntity);
            }
        }

        BaseEntity.Result result = new BaseEntity.Result();
        result.setUserList(list);

        baseEntity.setResult(result);
        return JSONObject.toJSONString(baseEntity);
    }

    /**
     * 测试版本升级
     */
    @RequestMapping("/checkVersion")
    @ResponseBody
    public String checkVersion(@RequestParam("req_version") String req_version,
                               @RequestParam("versionCode") int versionCode,
                               @RequestParam("type") int type) {

        AppVersionEntity<Object> baseEntity = new AppVersionEntity<>();
        baseEntity.setStates(200);
        baseEntity.setMsg("请求成功");

        AppVersionEntity.Result result = new AppVersionEntity.Result();
        result.setMsg("有新的更新版本");
        result.setType(1);
        result.setUrl("http://image.59cdn.com/app/apk/wajiu_3.70.0.apk");

        baseEntity.setResult(result);
        return JSONObject.toJSONString(baseEntity);
    }

    /**
     * 如果用postman测试的话
     * 1）Body中选择form-data,key填写为file,类型设置为File，value在本地选择图片
     * 2）Headers中不用自己随意去掉选项，否则会报400
     * @param file
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String testUpload(@RequestParam("file") List<MultipartFile> list) {
        List<String> filePathString = new ArrayList<>();

        UploadUtil uploadUtil = new UploadUtil();
        for(int i=0;i<list.size();i++){
            String fileName = "";
            if (uploadUtil.doUpload(list.get(i), "uploadImg")) {
                fileName = uploadUtil.getUploadFile();
            } else {
                fileName = "file";
            }
            filePathString.add(fileName);
        }
//        return fileName;
        UploadImageEntity uploadImageEntity = new UploadImageEntity();
        uploadImageEntity.setStates(200);
        uploadImageEntity.setMsg("上传成功");
        UploadImageEntity.Result result = new UploadImageEntity.Result();
        result.setFilePath(filePathString);
        uploadImageEntity.setResult(result);
        return JSONObject.toJSONString(uploadImageEntity);
    }


    /**
     * 测试post-form表单提交
     * @param list
     * @return
     */
    @RequestMapping(value = "/testPostWithForm", method = RequestMethod.POST)
    @ResponseBody
    public void testPostWithForm(@RequestParam("username") String username,@RequestParam("userAge") int userAge) {
        System.out.println("username="+username+",userAge="+userAge);
    }

    /**
     * 测试post-json提交
     */
    @RequestMapping(value = "/testPostWithJson", method = RequestMethod.POST)
    @ResponseBody
    public String testPostWithJson(@RequestBody HolidayEntity bean) {
        String result = JSONObject.toJSONString(bean);
            System.out.println(result);

            BaseEntity baseEntity = new BaseEntity();
            baseEntity.setMsg("请求成功");
            baseEntity.setStates(200);
        return JSONObject.toJSONString(baseEntity);
    }

    /**
     * 获取全部的用户数据
     *
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam("username") String username) {
        BaseEntity<Object> baseEntity = new BaseEntity<>();
        if (MoneyUtils.isEmpty(username)) {
            baseEntity.setStates(500);
            baseEntity.setMsg("用户名不能为空");
            return JSONObject.toJSONString(baseEntity);
        }
        List<UserEntity> list = (List<UserEntity>) userEntityService.findAll();
        int size = list.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (username.equals(list.get(i).getUsername())) {
                    baseEntity.setStates(201);
                    baseEntity.setMsg("用户名已经存在");
                    return JSONObject.toJSONString(baseEntity);
                }
            }
        }
        baseEntity.setStates(200);
        baseEntity.setMsg("请求成功");

        return JSONObject.toJSONString(baseEntity);
    }



    /**
     * 获取用户公司账户的数据
     *
     * @return
     */
    @RequestMapping("/getUserBalance")
    @ResponseBody
    public String getUserBalance() {
        UserBalanceCompanyEntity baseEntity = new UserBalanceCompanyEntity<>();
        baseEntity.setStates(200);
        baseEntity.setMsg("请求成功");

        UserBalanceCompanyEntity.Result result = new UserBalanceCompanyEntity.Result();

        List<UserBalanceCompanyEntity.Result.ListCompanyVOBean> listCompanyVO = new ArrayList<>();
        List<UserBalanceCompanyEntity.Result.ListBankCardBean> listBankCard = new ArrayList<>();
        for(int i=0;i<3;i++){
            UserBalanceCompanyEntity.Result.ListCompanyVOBean bean = new UserBalanceCompanyEntity.Result.ListCompanyVOBean();
            if(i == 0){
                bean.setName("test30的第一个公司账户");
                bean.setBalance("29613884.48");
            }else  if(i == 1){
                bean.setName("test30的第二个公司账户");
                bean.setBalance("37644318.57");
            }else  if(i == 2){
                bean.setName("贼有钱的一个账户");
                bean.setBalance("161961.96");
            }
            listCompanyVO.add(bean);
        }

        for(int i=0;i<6;i++){
            UserBalanceCompanyEntity.Result.ListBankCardBean bean = new UserBalanceCompanyEntity.Result.ListBankCardBean();
            if(i == 0){
                bean.setBankName("招商银行");
                bean.setBankCardNumber("6226200188385824");
                bean.setOwnerName("李连杰");
            }else if(i == 1){
                bean.setBankName("民生银行");
                bean.setBankCardNumber("6226200188382356");
                bean.setOwnerName("成龙");
            }else if(i == 2){
                bean.setBankName("花旗银行");
                bean.setBankCardNumber("6226200188386126");
                bean.setOwnerName("张飞");
            }else if(i == 3){
                bean.setBankName("建设银行");
                bean.setBankCardNumber("6226200188386666");
                bean.setOwnerName("马云");
            }else if(i == 4){
                bean.setBankName("交通银行");
                bean.setBankCardNumber("6226200188388977");
                bean.setOwnerName("赵云");
            }else if(i == 5){
                bean.setBankName("交通银行");
                bean.setBankCardNumber("6226200188381123");
                bean.setOwnerName("刘德华");
            }
            listBankCard.add(bean);
        }

        result.setListCompanyVO(listCompanyVO);
        result.setListBankCard(listBankCard);
        baseEntity.setResult(result);
        return JSONObject.toJSONString(baseEntity);
    }

    /**
     * 获取用户个人账户的数据
     *
     * @return
     */
    @RequestMapping("/getUserPersonalBalance")
    @ResponseBody
    public String getUserPersonalBalance() {
        UserBalancePersonalEntity baseEntity = new UserBalancePersonalEntity<>();
        baseEntity.setStates(200);
        baseEntity.setMsg("请求成功");

        UserBalancePersonalEntity.Result result = new UserBalancePersonalEntity.Result();
        result.setCanUserMoney("500000.00");

        List<UserBalancePersonalEntity.Result.ListBankCardBean> listBankCard = new ArrayList<>();
        for(int i=0;i<6;i++){
            UserBalancePersonalEntity.Result.ListBankCardBean bean = new UserBalancePersonalEntity.Result.ListBankCardBean();
            if(i == 0){
                bean.setBankName("招商银行");
                bean.setBankCardNumber("6226200188385824");
                bean.setOwnerName("李连杰");
            }else if(i == 1){
                bean.setBankName("民生银行");
                bean.setBankCardNumber("6226200188382356");
                bean.setOwnerName("成龙");
            }else if(i == 2){
                bean.setBankName("花旗银行");
                bean.setBankCardNumber("6226200188386126");
                bean.setOwnerName("张飞");
            }else if(i == 3){
                bean.setBankName("建设银行");
                bean.setBankCardNumber("6226200188386666");
                bean.setOwnerName("马云");
            }else if(i == 4){
                bean.setBankName("交通银行");
                bean.setBankCardNumber("6226200188388977");
                bean.setOwnerName("赵云");
            }else if(i == 5){
                bean.setBankName("交通银行");
                bean.setBankCardNumber("6226200188381123");
                bean.setOwnerName("刘德华");
            }
            listBankCard.add(bean);
        }
        result.setListBankCard(listBankCard);

        List<UserBalancePersonalEntity.Result.ListZhifubaoListBean> zhifubaoListBeans = new ArrayList<>();
        for(int i=0;i<3;i++){
            UserBalancePersonalEntity.Result.ListZhifubaoListBean bean = new UserBalancePersonalEntity.Result.ListZhifubaoListBean();
            if(i == 0){
                bean.setZhifubaoZhanghao("15201063591");
                bean.setZhifubaoUserName("李师师");
            }else if(i == 1){
                bean.setZhifubaoZhanghao("810914935@qq.com");
                bean.setZhifubaoUserName("张小三");
            }else if(i == 2){
                bean.setZhifubaoZhanghao("452345678@qq.com");
                bean.setZhifubaoUserName("刘小马");
            }
            zhifubaoListBeans.add(bean);
        }
        result.setListZhifubaoListBeans(zhifubaoListBeans);

        baseEntity.setResult(result);
        return JSONObject.toJSONString(baseEntity);
    }

    /**
     * 新增用户
     *
     * @param username
     */
    @RequestMapping("/save")
    @ResponseBody
    public String saveAndFlush(@RequestParam("username") String username) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
//        userEntityService.saveAndFlush(userEntity);

        List<UserEntity> list = (List<UserEntity>) userEntityService.findAll();
        int size = list.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (userEntity.getUsername().equals(list.get(i).getUsername())) {
                    BaseEntity<Object> baseEntity = new BaseEntity<>();
                    baseEntity.setStates(200);
                    baseEntity.setMsg("用户已经存在");

                    return JSONObject.toJSONString(baseEntity);
                }
            }
        }

        userEntityService.saveAndFlush(userEntity);

        List<UserEntity> listAfter = (List<UserEntity>) userEntityService.findAll();
        int sizeAfter = listAfter.size();
        if (sizeAfter > 0) {
            for (int i = 0; i < sizeAfter; i++) {
                if (userEntity.getUsername().equals(listAfter.get(i).getUsername())) {
                    BaseEntity<Object> baseEntity = new BaseEntity<>();
                    baseEntity.setStates(200);
                    baseEntity.setMsg("用户添加成功");

                    return JSONObject.toJSONString(baseEntity);
                }
            }
        }
        BaseEntity<Object> baseEntity = new BaseEntity<>();
        baseEntity.setStates(500);
        baseEntity.setMsg("服务器异常");
        return JSONObject.toJSONString(baseEntity);
    }
}
