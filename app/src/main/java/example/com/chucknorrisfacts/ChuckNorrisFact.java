package example.com.chucknorrisfacts;

import com.google.gson.annotations.SerializedName;

public class ChuckNorrisFact {
    public String type;


    public Value value;

    public class Value {
        public String joke;
    }
}
