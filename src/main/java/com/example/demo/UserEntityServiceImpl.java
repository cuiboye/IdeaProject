package com.example.demo;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityServiceImpl implements UserEntityService {
    @Autowired
    private UserEntityRepository userEntityRepository;

    @Override
    public List<UserEntity> findByUserid(Integer userid) {
        return userEntityRepository.findByUserid(userid);
    }

    @Override
    public List<UserEntity> findAll() {
        return userEntityRepository.findAll();
    }

    @Override
    public String saveAndFlush(UserEntity userEntity) {
        List<UserEntity> list = userEntityRepository.findAll();
        int size = list.size();
        if(size>0){
            for (int i=0;i<size;i++){
                if(userEntity.getUsername().equals(list.get(i).getUsername())){
                    BaseEntity<Object> baseEntity = new BaseEntity<>();
                    baseEntity.setStates(200);
                    baseEntity.setMsg("用户已经存在");

                    return JSONObject.toJSONString(baseEntity);
                }
            }
        }

        userEntityRepository.saveAndFlush(userEntity);

        List<UserEntity> listAfter = (List<UserEntity>)userEntityRepository.findAll();
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
