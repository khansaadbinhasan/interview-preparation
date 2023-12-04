package leetcode.medium;

//"https://leetcode.com/problems/design-tinyurl"
//"https://leetcode.com/problems/design-tinyurl34453434"
public class L535DecodeTinyUrl {
    public class Codec {

        private String shortUrl;
        private String longUrl;

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            this.longUrl = longUrl;
            return "";
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return longUrl;
        }
    }

    // Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
}
