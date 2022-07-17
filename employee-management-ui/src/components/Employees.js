
import { Link } from "react-router-dom";
import { Button } from "react-bootstrap";
import { SAVE_EMPLOYEES_PAGE_URL } from "../lib/url/pageUrlConstants";
import EmployeesTable from "./tables/EmployeesTable";

export default function Employees() {
    console.log('here');
    return (
        <div>
            <Link className='mb-3' to={SAVE_EMPLOYEES_PAGE_URL}>
                <Button>Add Employee</Button>
            </Link>
            <EmployeesTable />
        </div>
    );
}
