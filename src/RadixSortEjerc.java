import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSortEjerc
{
	public static void radixSort(int []arr)
	{
		// convertimos el array en array de strings
		String stringArray[] = StringUtil.toStringArray(arr);

		// completamos con 0 a la izquierda todos los elementos para que tengan la misma longitud
		StringUtil.lNormalize(stringArray, '0');

		// creamos la lista madre que contiene 10 listas
		List<List<String>> motherList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			motherList.add(new ArrayList<>());
		}
		
		// recorremos el arreglo para ir llenando las listas
		// (se repite N veces, siendo N la cantidad de digitos del string mas largo presente en el arreglo)
		int maxLength = StringUtil.maxLength(stringArray);
		int index;

		for (int i = maxLength; i > 0; i--) {
			for (int j = 0; j < stringArray.length; j++) {
				String str = stringArray[j];
				char digit = str.charAt(i - 1);
				motherList.get(Character.getNumericValue(digit)).add(str);
			}
			
			// borramos el arreglo anterior
			stringArray = new String[stringArray.length];
			
			// cargamos el arreglo teniendo en cuenta el orden
			index = 0;

			for (List<String> list: motherList) {
				for (String element: list) {
					stringArray[index] = element;
					index++;
				}
				list.clear();
			}

		}

		int finalIntArray[] = StringUtil.toIntArray(stringArray);
		for (int k = 0; k < finalIntArray.length; k++) {
			arr[k] = finalIntArray[k];
		}
	}

	public static void main(String[] args)
	{
		int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
		System.out.println("Ordenamos usando el algoritmo radixSort el arreglo: ");
		System.out.println(Arrays.toString(arr));
		System.out.println("");

		radixSort(arr);

		System.out.println("¡Arreglo ordenado! Resultado: ");
		System.out.println(Arrays.toString(arr));
	}
}
