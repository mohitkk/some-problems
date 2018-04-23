package general;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
interface contact {
    public void addContact(String name);
    public int findContact(String name);
}
public class Contacts implements contact {
    TrieNode root;
    Map<Character, List<TrieNode>> contacts;
    Contacts (){
        root = new TrieNode();
    }
    public static void main(String args[]){
        Contacts c = new Contacts();
    }

//    public void addContact(String name){
//
//    }
    public void addContact(String name){
        Map<Character, List<TrieNode>> children = root.words;
        for( int i =0; i<name.length();i++){
            char c = name.charAt(i);
            TrieNode t;
            if(children.containsKey(c)){
                List<TrieNode> ll = children.get(c);
//                children =
            }
        }
    }

    public int findContact(String name){

        return 0;
    }


    private class TrieNode {
        boolean isWord;
        char value;
        Map<Character, List<TrieNode>> words;
        TrieNode(){
            words = new HashMap<Character, List<TrieNode>>();
            isWord = false;
        }
        TrieNode(char c, boolean isWord){
            this.value = c;
            this.isWord =isWord;
            words = new HashMap<Character, List<TrieNode>>();
        }

        @Override
        public String toString(){
            return "[value"+value+",isWord"+isWord+",words "+words+"]";
        }
    }
}
