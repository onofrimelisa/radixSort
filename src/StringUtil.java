import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringUtil
{
	// Retorna una cadena compuesta por n caracteres c
	// Ejemplo: replicate('x',5) ==> 'xxxxx'
	public static String replicate(char c, int n)
	{
		String cadena = "";
		for (int i = 0; i < n; i++) {
			cadena = cadena + c;
		}
		return cadena;
	}

	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	// Ejemplo lpad("5",3,'0') ==> "005"
	public static String lpad(String s, int n, char c)
	{
		int longitud = s.length();

		if(longitud < n) {
			int diferencia = n - longitud;
			s = replicate(c, diferencia) + s;
		}

		return s;
	}

	// Retorna un String[] conteniendo los elementos de arr
	// representados como cadenas de caracteres
	public static String[] toStringArray(int arr[])
	{
		int longitud = arr.length;
		String stringArray[] = new String[longitud];

		for (int i = 0; i < longitud; i++) {
			stringArray[i] = String.valueOf(arr[i]);
		}
		return stringArray;
	}

	// Retorna un int[] conteniendo los elementos de arr
	// representados como enteros
	public static int[] toIntArray(String arr[])
	{
		int longitud = arr.length;
		int intArray[] = new int[longitud];

		for (int i = 0; i < longitud; i++) {
			intArray[i] = Integer.valueOf(arr[i]);
		}
		return intArray;
	}

	// Retorna la longitud del elemento con mayor cantidad
	// de caracteres del array arr
	public static int maxLength(String arr[])
	{
		List<String> strings = Arrays.asList(arr);

		String mayorLongitud = strings.stream().max(Comparator.comparingInt(String::length)).get();
		return mayorLongitud.length();
	}

	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String arr[], char c)
	{
		int maxLongitud = maxLength(arr);

		for (int i = 0; i < arr.length; i++) {
			arr[i] = lpad(arr[i], maxLongitud, c);
		}
	}
}
