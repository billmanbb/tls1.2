import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpsClient {
    public static void main(String[] args) {
        try {
            // 服务器 URL
            URL url = new URL("https://yourserver.com/endpoint");

            // 打开连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "text/plain");

            // 发送 "hello" 字符串
            String message = "hello";
            OutputStream os = connection.getOutputStream();
            os.write(message.getBytes());
            os.flush();
            os.close();

            // 获取响应代码
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // 关闭连接
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
