package de.teleran;

import de.teleran.operation.IStringOperation;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.reflect.InvocationTargetException;


/**
 * Loads and provides all operations by their names
 */
public class OperationContext {

    // stores operations by their names
    Map<String, IStringOperation> operationsSource ;

    /**
     * The method creates instances for all the operations by their names and places them into operationsSource
     *
     * @param operationPaths the paths to the operations ('de.telran.operation.UpperCaseOperation')
     */
    public void loadOperations(List<String> operationPaths)throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        operationsSource = new HashMap<>();

        for (String operationPath : operationPaths) {
            IStringOperation operation = (IStringOperation) Class.forName(operationPath).getConstructor().newInstance();
            operationsSource.put(operation.getName(), operation);
        }
    }


    public IStringOperation getOperation(String name) {
        return operationsSource.get(name);
    }
}