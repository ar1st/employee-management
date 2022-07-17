import { Route, Routes } from "react-router-dom"
import Attributes from '../Attributes'
import Employees from '../Employees'
import Map from '../Map'
import SaveAttributeForm from "../forms/SaveAttributeForm"
import { SAVE_ATTRIBUTE_PAGE_URL, ATTRIBUTES_PAGE_URL, EMPLOYEES_PAGE_URL, MAP_PAGE_URL, SAVE_EMPLOYEES_PAGE_URL } from "../../lib/url/pageUrlConstants"
import SaveEmployeeForm from "../forms/SaveEmployeeForm"

export default function Body() {

    return (
        <div className="content">
            <Routes>
                <Route exact path={ATTRIBUTES_PAGE_URL} element={<Attributes />} />
                <Route exact path={SAVE_ATTRIBUTE_PAGE_URL} element={<SaveAttributeForm />} />
                <Route path={EMPLOYEES_PAGE_URL} element={<Employees />} />
                <Route exact path={SAVE_EMPLOYEES_PAGE_URL} element={<SaveEmployeeForm />} />
                <Route path={MAP_PAGE_URL} element={<Map />} />
            </Routes>
        </div>
    )
}