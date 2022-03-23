package jfuzzylogic;



import net.sourceforge.jFuzzyLogic.FIS;
import org.jfree.chart.JFreeChart;
//import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

/**
 * Test parsing an FCL file
 * @author pcingola@users.sourceforge.net
 */
public class JFuzzy {
    public static void main(String[] args) throws Exception {
        // Load from 'FCL' file
        String fileName = "src/jfuzzylogic/relevancia.fcl";
        FIS fis = FIS.load(fileName,true);
        // Error while loading?
        if( fis == null ) { 
            System.err.println("Can't load file: '" 
                                   + fileName + "'");
            return;
        }
        //Interface gui = new Interface();
        //gui.show();
        
        // Mostra gráficos 
        fis.chart();

        //Requisito: Notificate by email
        // Dados de entrada
        //56.1%
        fis.setVariable("winratio", 0.516);
        //2.5%
        fis.setVariable("pickratio", 0.025);
        //1.9%
        fis.setVariable("banratio", 0.019);
        //56.1%
        fis.setVariable("kda", 0.032);
        // Calcular
        fis.evaluate();
        // Mostrar gráfico das variaveis de saida
        fis.getVariable("desempeño").chartDefuzzifier(true);
        System.out.println("Desempeño = "+fis.getVariable("desempeño").getValue());
        
        // Print ruleSet;
        // System.out.println(fis);
    }
}