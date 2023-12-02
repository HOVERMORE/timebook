package hc.timebook;

import hc.common.customize.RedisCacheClient;
import hc.common.dtos.ResponseResult;
import hc.service.*;
import hc.thread.UserHolder;
import hc.uniapp.album.pojos.Album;
import hc.uniapp.user.pojos.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.concurrent.TimeUnit;

import static hc.common.constants.RedisConstants.CACHE_ALBUM_KEY;
import static hc.common.constants.RedisConstants.CACHE_ALBUM_TTL;

@SpringBootTest
public class UniappServiceTest {
    @Resource
    private SearchService searchService;
    @Resource
    private AlbumService albumService;
    @Resource
    private RedisCacheClient redisCacheClient;
    @Resource
    private UserService userService;
    @Resource
    private ImageAlbumService imageAlbumService;
    @Resource
    private ImagesService imagesService;
    @Test
    void test(){
        setUser();
        String content="全 全 人 人 人像 2023-12-01 2023-12-02 2023-12-01";
        ResponseResult result = searchService.searchAll(content);
        System.out.println(result.getCode());
        System.out.println(result.getData().toString());
    }

    @Test
    void testRedis(){
        setUser();
        Album album=albumService.getById("1729076022051225602");
        album=redisCacheClient.queryWithPassThrough(CACHE_ALBUM_KEY,album.getAlbumId()
                ,Album.class,albumService::getById,CACHE_ALBUM_TTL, TimeUnit.MINUTES);
        if(album==null)
            System.out.println("该相册不存在");
        else
            album.toString();
    }
    void setUser(){
        User byId = userService.getById("1729076021958950914");
        UserHolder.saveUser(byId);
    }
    @Test
    void testDefault(){
        setUser();
        imagesService.deleteImage("1111","1111");
    }
}
