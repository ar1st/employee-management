
import { Link } from "react-router-dom";
import { EMPLOYEES_PAGE_URL, MAP_PAGE_URL, ATTRIBUTES_PAGE_URL } from "../../lib/url/pageUrlConstants";

export default function Header() {

    return (
        <div>
            <h1 className="title">Employee management</h1>
            <ul className="navigation-bar">
                <li><Link to={ATTRIBUTES_PAGE_URL}>Attributes</Link></li>
                <li><Link to={EMPLOYEES_PAGE_URL}>Employees</Link></li>
                <li><Link to={MAP_PAGE_URL}>Map</Link></li>
            </ul>
        </div>
    );
}
