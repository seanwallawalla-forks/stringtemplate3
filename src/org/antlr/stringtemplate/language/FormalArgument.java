package org.antlr.stringtemplate.language;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

/** Represents the name of a formal argument
 *  defined in a template:
 *
 *  group test;
 *  test(a,b) : "$a$ $b$"
 *  t() : "blort"
 *
 *  Each template has a set of these formal arguments or uses
 *  a placeholder object: UNKNOWN (indicating that no arguments
 *  were specified such as when a template is loaded from a file.st).
 *
 *  Note: originally, I tracked cardinality as well as the name of an
 *  attribute.  I'm leaving the code here as I suspect something may come
 *  of it later.  Currently, though, cardinality is not used.
 */
public class FormalArgument {
    // the following represent bit positions emulating a cardinality bitset.
    public static final int OPTIONAL = 1;     // a?
    public static final int REQUIRED = 2;     // a
    public static final int ZERO_OR_MORE = 4; // a*
    public static final int ONE_OR_MORE = 8;  // a+

    public static final String[] suffixes = {
        null,
        "?",
        "",
        null,
        "*",
        null,
        null,
        null,
        "+"
    };

    /** When template arguments are not available such as when the user
     *  uses "new StringTemplate(...)", then the list of formal arguments
     *  must be distinguished from the case where a template can specify
     *  args and there just aren't any such as the t() template above.
     */
    public static Map UNKNOWN = new HashMap();

    protected String name;
    //protected int cardinality = REQUIRED;

    public FormalArgument(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getCardinalityName(int cardinality) {
        switch (cardinality) {
            case OPTIONAL : return "optional";
            case REQUIRED : return "exactly one";
            case ZERO_OR_MORE : return "zero-or-more";
            case ONE_OR_MORE : return "one-or-more";
            default : return "unknown";
        }
    }

    public String toString() {
        return getName();
    }
}