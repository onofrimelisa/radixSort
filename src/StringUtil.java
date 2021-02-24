import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringUtil
{
	// Retorna una cadena compuesta por n caracteres c
	// Ejemplo: replicate('x',5) ==> 'xxxxx'
	public static String replicate(char c, int n)
	{
		String str = "";

		for (int i = 0; i < n; i++) {
			str = str + c;
		}

		return str;
	}

	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	// Ejemplo lpad("5",3,'0') ==> "005"
	public static String lpad(String s, int n, char c)
	{
		int length = s.length();

		if(length < n) {
			int difference = n - length;
			s = replicate(c, difference) + s;
		}

		return s;
	}

	// Retorna un String[] conteniendo los elementos de arr
	// representados como cadenas de caracteres
	public static String[] toStringArray(int arr[])
	{
		int length = arr.length;
		String stringArray[] = new String[length];

		for (int i = 0; i < length; i++) {
			stringArray[i] = String.valueOf(arr[i]);
		}

		return stringArray;
	}

	// Retorna un int[] conteniendo los elementos de arr
	// representados como enteros
	public static int[] toIntArray(String arr[])
	{
		int length = arr.length;
		int intArray[] = new int[length];

		for (int i = 0; i < length; i++) {
			intArray[i] = Integer.valueOf(arr[i]);
		}

		return intArray;
	}

	// Retorna la longitud del elemento con mayor cantidad
	// de caracteres del array arr
	public static int maxLength(String arr[])
	{
		List<String> strings = Arrays.asList(arr);
		String maxLength = strings.stream().max(Comparator.comparingInt(String::length)).get();

		return maxLength.length();
	}

	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String arr[], char c)
	{
		int maxLength = maxLength(arr);

		for (int i = 0; i < arr.length; i++) {
			arr[i] = lpad(arr[i], maxLength, c);
		}
	}
}
