package az.azex.repository.implementation;

public class SqlQuery {
    public static final String GET_PERSON_LIST = "select id, name, surname, status from person where status = 1";
    public static final String GET_PERSON_BY_ID = "select id, name, surname, status from person where status = 1 and id = ?";

    public static final String AUTHENTICATE_USER = "select id, email, password from azex_user " +
            " where email = ? and password = ? and status = 1";

    public static final String GET_USER_ROLES = "select ur.role_id, r.name, " +
            " r.default_controller, r.default_page " +
            "from azex_user u join user_role ur on u.id = ur.user_id and ur.status = 1 " +
            "  join role r on r.id = ur.role_id and r.status = 1 " +
            "where u.id = ?";

    public static final String GET_FLEXIBLE_LIST_BY_ID = "select id, name from flexible_list " +
            " where id = ? and status = 1";

    public static final String GET_FLEXIBLE_LIST_BY_NAME = "select id, name from flexible_list " +
            " where name = ? and status = 1";

    public static final String GET_FLEXIBLE_LIST_ITEMS_BY_LIST_ID = "select fli.id, fli.value_id, fli.value_name, fli.insert_date " +
            "from flexible_list fl join flexible_list_item fli on fl.id = fli.list_id " +
            "   and fl.status = 1 and fli.status = 1 " +
            "where fl.id = ? " +
            "order by fli.value_id";


    public static final String GET_FLEXIBLE_LIST_ITEMS_BY_LIST_NAME = "select fli.id, fli.value_id, fli.value_name, fli.insert_date " +
            "from flexible_list fl join flexible_list_item fli on fl.id = fli.list_id " +
            "   and fl.status = 1 and fli.status = 1 " +
            "where fl.name = ? " +
            "order by fli.value_id";

    public static final String GET_ALL_FLEXIBLE_LIST = "select id, name from flexible_list " +
            " where status = 1";

}
