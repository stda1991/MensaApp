package de.hsulm.mensaapp.SQL_SET_OR_FETCH_COMMENT;

import java.util.ArrayList;
import de.hsulm.mensaapp.CommentsClass;

public interface IDatabaseOperationsComments {

    void onSuccess(boolean isDefault);

    void onSuccess(boolean isDefault, ArrayList<CommentsClass> comments_list);

}
