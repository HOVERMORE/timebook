package hc.common.constants;

public class RedisConstants {

    public static final String LOGIN_USER_KEY = "login:user:";
    public static final Long LOGIN_USER_TTL = 14L;
    public static final String CACHE_USER_KEY="user:";
    public static Long CACHE_USER_TTL=14L;
    public static final String CACHE_ALBUM_KEY="album:";
    public static final Long CACHE_ALBUM_TTL=14L;
    public static final String CACHE_IMAGE_KEY="image:";
    public static final Long CACHE_IMAGE_TTL=14L;
    public static final String DEFAULT_ALBUM_KEY="default:album:user:";
    public static final Long DEFAULT_ALBUM_TTL=14L;
    public static final String CACHE_ALBUM_IMAGE_DTO_KEY="albumImageDto:";
    public static final Long CACHE_ALBUM_IMAGE_DTO_TTL=14L;
    public static final String LOCK_ALBUM_IMAGE_DTO_KEY="lock:albumImageDto:";
    public static final String LOCK_ALBUM_IMAGE_VALUE_KEY="1";
    public static final Long LOCK_ALBUM_IMAGE_DTO_TTL=10L;
    public static final Long CACHE_NULL_TTL = 2L;
}
