import java.lang.*;
import java.util.*;
import java.io.*;

public class InfotainmentSystem<Key, Value> {
	HashMap<Integer, ArrayList<String>> hm = new HashMap<Integer, ArrayList<String>>();
	ArrayList<String>[] MoviesTitle = (ArrayList<String>[])new ArrayList[2];
	int[] arr = new int[100000];
	public ArrayList[] MovieSolver(int movies_length) throws IOException{
		String line;
		
		try{
			FileReader file = new FileReader("movies.csv");
			BufferedReader buffer = new BufferedReader(file);
			while((line = buffer.readLine()) != null){
				String[] strsplit = line.split(",");
				if (hm.get(Integer.parseInt(strsplit[1])) == null) {
				    hm.put(Integer.parseInt(strsplit[1]), new ArrayList<String>());
				}
				hm.get(Integer.parseInt(strsplit[1])).add(strsplit[0]);
			};
			Set set = hm.entrySet();
			Iterator i = set.iterator();
			
			while(i.hasNext())
			{	
				Map.Entry map = (Map.Entry)i.next();
         		int movie_1_length = (int)map.getKey();
         		int diff = movies_length - movie_1_length;
         		if(diff >= 0 && arr[diff] == 1)
         		{
         			MoviesTitle[0] = (ArrayList<String>)hm.get(diff);
         			MoviesTitle[1] = (ArrayList<String>)hm.get(movie_1_length);
         			break;
         		}
         		arr[movie_1_length] = 1;
			}
		}catch(IOException e){
			System.out.println("Exception Occurred");
		}
		return MoviesTitle;
	};
	public static void main(String[] args) throws Exception{
		InfotainmentSystem var = new InfotainmentSystem();
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Journey Time (in min) : ");
		int movie_length = sc.nextInt();
		ArrayList[] movies = new ArrayList[2];
		movies = var.MovieSolver(movie_length);
		int i=0;
		System.out.println("Movie 1 : ");
		while(movies[0].size() > i)
        {
        	System.out.print(movies[0].get(i));
        	if(movies[0].size() != (i+1))
        	System.out.print(", ");
        	i++;
		}
		i=0;
		System.out.println("\n\nMovie 2 : ");
		while(movies[1].size() > i)
		{
        	System.out.print(movies[1].get(i));
        	if(movies[1].size() != (i+1))
        	System.out.print(", ");
        	i++;
        }
        System.out.print("\n\n");
	}
}