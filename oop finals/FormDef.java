public class FormDef {
    public final String title, table;
    public final String[] cols, labels;

    public FormDef(String title, String table, String[] cols, String[] labels) {
        this.title = title;
        this.table = table; 
        this.cols = cols; 
        this.labels = labels;
    }

    public static final FormDef EMPLOYEE = new FormDef("Employee Masterfile (201)", "employee",
        new String[]{"emp_id", "last_name", "first_name", "middle_name", "birth_date", "gender", "position", "department", "date_hired", "salary", "contact_no", "address"},
        new String[]{"Employee ID", "Last Name", "First Name", "Middle Name", "Birth Date (YYYY - MM - DD", "Gender", "Position", "Department", "Date Hired (YYYY-MM-DD)", "Monthyly Salary", "Contact No.", "Address"}
    );

     public static final FormDef STUDENT = new FormDef("Student Information", "student",
        new String[]{"student_id","last_name","first_name","middle_name","birth_date","gender","course","year_level","section","email","contact_no","address"},
        new String[]{"Student ID","Last Name","First Name","Middle Name","Birth Date (yyyy-MM-dd)","Gender","Course","Year Level","Section","Email","Contact No.","Address"});
 
    public static final FormDef PRODUCT = new FormDef("Product/Item Information", "product",
        new String[]{"item_code","description","category","unit","unit_price","quantity","reorder_level","supplier"},
        new String[]{"Item Code","Description","Category","Unit","Unit Price","Quantity","Reorder Level","Supplier"});
 
    public static final FormDef BOOK = new FormDef("Book Information", "book",
        new String[]{"book_id","isbn","title","author","publisher","year_published","category","edition","copies"},
        new String[]{"Book ID","ISBN","Title","Author","Publisher","Year Published","Category","Edition","Copies"});
 
    public static final FormDef PATIENT = new FormDef("Patient Information", "patient",
        new String[]{"patient_id","last_name","first_name","middle_name","birth_date","gender","blood_type","contact_no","address","guardian","date_admitted","diagnosis"},
        new String[]{"Patient ID","Last Name","First Name","Middle Name","Birth Date (yyyy-MM-dd)","Gender","Blood Type","Contact No.","Address","Guardian / Emergency Contact","Date Admitted (yyyy-MM-dd)","Diagnosis"});
}