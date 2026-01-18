import controller.ClienteController;
import motor.MotorRegras;
import regras.InadimplenteRegra;
import regras.NovoClienteRegra;
import regras.VipRegra;
import repository.ClienteRepository;
import service.ClienteService;
import view.MenuView;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        MotorRegras motor = new MotorRegras(List.of(
                new InadimplenteRegra(),
                new VipRegra(),
                new NovoClienteRegra()
        ));

        ClienteService service = new ClienteService(
                new ClienteRepository(),
                motor
        );

        ClienteController controller = new ClienteController(
                service,
                new MenuView()
        );

        controller.iniciar();
    }
}
