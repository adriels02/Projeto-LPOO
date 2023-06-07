package preços;

import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


public class util {
static NumberFormat numberFormat = new DecimalFormat("R$#,##0,00",new DecimalFormatSymbols(new Locale("pt","BR")));
	
public static String doubleString(String valor) {
	return numberFormat.format(valor);
}
}
