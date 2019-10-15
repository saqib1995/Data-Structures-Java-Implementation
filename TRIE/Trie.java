import java.util.HashMap;

public class Trie {

    public class TrieNode {


        boolean isEndOfWord;
        HashMap<Character, TrieNode> characterHash;

        public TrieNode() {
            isEndOfWord = false;
            characterHash = new HashMap<>();
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insertString(String val) {

        char[] valChar = val.toCharArray();
        char currentCharacter;
        TrieNode currentNode;
        currentNode = root;
        for(int i = 0 ; i < valChar.length ; i++) {

            currentCharacter = valChar[i];

            if(!currentNode.characterHash.containsKey(currentCharacter)) {
                currentNode.characterHash.put(currentCharacter, new TrieNode());
            }


            currentNode = currentNode.characterHash.get(currentCharacter);
        }

        currentNode.isEndOfWord = true;
    }


    public boolean searchString(String val) {
        char[] searchArray = val.toCharArray();
        TrieNode currentNode = root;
        char currentCharacter;
        for(int i = 0 ; i < searchArray.length ; i++) {
            currentCharacter = searchArray[i];

            if(!currentNode.characterHash.containsKey(currentCharacter)) {
                return false;
            }
            currentNode = currentNode.characterHash.get(currentCharacter);


        }
        return currentNode.isEndOfWord;
    }


}
