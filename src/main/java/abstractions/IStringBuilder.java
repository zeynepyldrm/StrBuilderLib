package abstractions;

public interface IStringBuilder {
    void append(String str);
    void insert(int start, String str);
    void delete(int start,int finish);
    void reverse();
    String toString();
    char[] toCharArray();
}
