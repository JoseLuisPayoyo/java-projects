package jose.zona_fit;

import com.formdev.flatlaf.FlatDarculaLaf;
import jose.zona_fit.gui.ZonaFitForma;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class ZonaFitSwim {
    public static void main(String[] args) {
        // configuramos el modo oscuro
        FlatDarculaLaf.setup();
        //Instanciar la fabrica de spring
        ConfigurableApplicationContext contextoSpring = new SpringApplicationBuilder(ZonaFitSwim.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .run(args);

        //Crear objeto de swim
        SwingUtilities.invokeLater(()-> {
            ZonaFitForma zonaFitForma = contextoSpring.getBean(ZonaFitForma.class);
            zonaFitForma.setVisible(true);
        });
    }
}
