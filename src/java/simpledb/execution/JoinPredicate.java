package simpledb.execution;

import simpledb.storage.Field;
import simpledb.storage.Tuple;

import java.io.Serializable;

/**
 * JoinPredicate compares fields of two tuples using a predicate. JoinPredicate
 * is most likely used by the Join operator.
 */
public class JoinPredicate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor -- create a new predicate over two fields of two tuples.
     * 
     * @param field1
     *            The field index into the first tuple in the predicate
     * @param field2
     *            The field index into the second tuple in the predicate
     * @param op
     *            The operation to apply (as defined in Predicate.Op); either
     *            Predicate.Op.GREATER_THAN, Predicate.Op.LESS_THAN,
     *            Predicate.Op.EQUAL, Predicate.Op.GREATER_THAN_OR_EQ, or
     *            Predicate.Op.LESS_THAN_OR_EQ
     * @see Predicate
     */

    private int _field1;
    private int _field2;
    private Predicate.Op _op;

    public JoinPredicate(int field1, Predicate.Op op, int field2) {
        // some code goes here
        _field1 = field1;
        _field2 = field2;
        _op = op;
    }

    /**
     * Apply the predicate to the two specified tuples. The comparison can be
     * made through Field's compare method.
     * 
     * @return true if the tuples satisfy the predicate.
     */
    public boolean filter(Tuple t1, Tuple t2) {
        // some code goes here
        Field t1f = t1.getField(_field1);
        Field t2f = t2.getField(_field2);
        return t1f.compare(_op, t2f);
    }
    
    public int getField1()
    {
        // some code goes here
        return _field1;
    }
    
    public int getField2()
    {
        // some code goes here
        return _field2;
    }
    
    public Predicate.Op getOperator()
    {
        // some code goes here
        return _op;
    }
}
