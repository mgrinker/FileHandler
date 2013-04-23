
package filehandler;

/**
 *
 * @author Michael
 */
public interface FileFormatStrategy<T, E> {

    public abstract T decodeData(E dataFromFile);

    public abstract String encodeData(T dataFromFile);
    
}
