package general;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
interface contact {
    public void addContact(String name);
    public int findContact(String name);
}
public class Contacts implements contact {
    TrieNode root;
    Contacts (){
        root = new TrieNode('r');
    }
    public static void main(String args[]){
        Contacts c = new Contacts();
        c.addContact("Kamla");
        c.addContact("Kamal");
        c.addContact("Kamalpreet");
        c.addContact("Harsha");
        c.addContact("Harsh");
        c.addContact("Hasan");
        c.addContact("Savleen");
        c.addContact("Kamlesh");

        System.out.println(c.root);
        System.out.println(c.findContact("Kam"));
        System.out.println(c.findContact("Ha"));
        System.out.println(c.findContact("Hasan"));
        System.out.println(c.findContact("Kamala"));
        System.out.println(c.findContact("parmeet"));

//        if(c.deleteContact("Harsh")){
//            System.out.println(c.deleteContact("Harsh",c.root));
//        }
        if(c.deleteContact("Harsha")){
            System.out.println(c.deleteContact("Harsha",c.root));
        }
        System.out.println(c.findContact("Ha"));
        System.out.println(c.root);

    }

//    public void addContact(String name){
//
//    }

    public void addContact(String name){
        Map<Character, TrieNode> words = root.words;
        for( int i =0; i<name.length();i++){
            char c = name.charAt(i);
            TrieNode t;
            if(words.containsKey(c)){
                t = words.get(c);
            }else{
                t = new TrieNode(c);
                words.put(c,t);
            }
            words = t.words;
            //set leaf node
            if(i==name.length()-1) {
                t.isWord = true;
            }
        }
    }
    public boolean deleteContact(String name){
        System.out.println("deleting called on: "+name);
        Map<Character, TrieNode> words = root.words;
        TrieNode t = null;
        for(int i = 0;i<name.length();i++){
            char c = name.charAt(i);
            if(words.containsKey(c)){
                t = words.get(c);
                words = t.words;
            }
            else{
                break;
            }
        }

        if(t != null){
            if (t.isWord){
//                if(t.words.size()==0){
//
//                }
//                t.isWord = false;
                return true;
            }
        }

        return false;
    }

    public boolean deleteContact(String name, TrieNode node ){
        if(name.length() == 0 && node != null){
            if(node.words.size() == 0){
                return true;
            }else{
                node.isWord = false;
                return false;
            }
        }
        else {
            char c =  name.charAt(0);
            boolean result = deleteContact(name.substring(1), node.words.get(c));
            if(result){
                node.words.remove(c);
            }
            if(node.words.size() == 0 && !node.isWord){
                return true;
            }
        }
        return false;
    }
    public int findContact(String name){
        Map<Character, TrieNode> words = root.words;
        List<String> possibleWords = new ArrayList<>();
        TrieNode t = null;
        for(int i = 0; i<name.length();i++){
            char c = name.charAt(i);
            if(words.containsKey(c)) {
                t = words.get(c);
            }else{
                t = null;
                break;
            }
            words = t.words;
        }
        if(t != null){
            findContact(t,possibleWords, name);
        }
        System.out.println(possibleWords);
        return possibleWords.size();
    }
    public void findContact(TrieNode t, List<String> possibleWords, String parent){
        if(t.isWord == true){
            possibleWords.add(parent);
        }
        Map<Character, TrieNode> tt = t.words;
        for(Character c : tt.keySet()){
            findContact(tt.get(c),possibleWords,parent+tt.get(c).value);
        }
    }


    private class TrieNode {
        boolean isWord;
        char value;
        Map<Character, TrieNode> words;
        TrieNode(){
            words = new HashMap<Character, TrieNode>();
            isWord = false;
        }
        TrieNode(char c){
            this(c,false);
        }
        TrieNode(char c, boolean isWord){
            this.value = c;
            this.isWord =isWord;
            words = new HashMap<Character, TrieNode>();
        }

        @Override
        public String toString(){
            return "{value="+value+", isWord="+isWord+", words=["+words+"]}";
        }
    }
}
