package Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovimentacaoMandatoryFields {

    Map<String, String> mandatoryFields = new HashMap();

    public MovimentacaoMandatoryFields(){
        mandatoryFields.put("dataMovimento","Data da Movimentação é obrigatório");
        mandatoryFields.put("dataPgto","Data do pagamento é obrigatório");
        mandatoryFields.put("descricao","Descrição é obrigatório");
        mandatoryFields.put("interessado","Interessado é obrigatório");
        mandatoryFields.put("valor", "Valor é obrigatório");
        mandatoryFields.put("caracterValor","Valor deve ser um número");
    }

    public Map<String,String> getMandatoryFields(){
        return mandatoryFields;
    }
}
