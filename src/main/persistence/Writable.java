package persistence;

import org.json.JSONObject;

// Code for this class was referenced off the sample project given for phase 2
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
