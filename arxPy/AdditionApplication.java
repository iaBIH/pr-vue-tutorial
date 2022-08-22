//AdditionApplication.java
import py4j.GatewayServer;

public class AdditionApplication {

  public static void main(String[] args) {
    AdditionApplication app = new AdditionApplication();
    // app is now the gateway.entry_point
    GatewayServer server = new GatewayServer(app);
    server.start();
  }
}
