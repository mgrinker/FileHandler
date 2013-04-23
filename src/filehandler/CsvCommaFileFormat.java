
package filehandler;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Michael
 */
public class CsvCommaFileFormat implements FileFormatStrategy<List<LinkedHashMap<String, String>>,List<String>> {
    private static final String CRLF = "\n";
    private static final String COMMA = ",";
    
    private boolean hasHeader;
    
    public CsvCommaFileFormat(boolean hasHeader) {
        this.hasHeader = hasHeader;
    }
    
    @Override
    public String encodeData(List<LinkedHashMap<String, String>> dataFromSrc) {
        StringBuilder formattedData = new StringBuilder();
     
    return formattedData.toString();    
    }
    
    
    
    @Override
    public List<LinkedHashMap<String, String>> decodeData(List<String> dataFromSrc) {
        
        List<LinkedHashMap<String, String>> decodedData =
                new ArrayList<LinkedHashMap<String, String>>();

        String[] headerFields = null;
        for (int recordNo = 0; recordNo < dataFromSrc.size(); recordNo++) {
            String firstRow = dataFromSrc.get(recordNo);
            
            String[] fields = dataFromSrc.get(recordNo).split(COMMA);
            if (hasHeader && (recordNo == 0)) { 
                headerFields = fields;
            }

            LinkedHashMap<String, String> record = new LinkedHashMap<String, String>();
            
            for (int i = 0; i < fields.length; i++) {
                if (hasHeader && (recordNo == 0)) {
                    break;
                } else if (hasHeader) {
                    record.put(headerFields[i], fields[i]);   
                } else {
                    record.put("" + i, fields[i]);
                }
            }

            
            if (recordNo != 0) {
                decodedData.add(record);
            }
        }
        return decodedData;
        
    }
}
