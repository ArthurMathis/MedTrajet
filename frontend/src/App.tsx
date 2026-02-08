import './App.css'
import { Routes, Route } from 'react-router-dom';
import Login from "./layouts/pages/Login.tsx";
import HomePage from "./layouts/pages/HomePage.tsx";

function App() {
      return (
          <Routes>
              <Route path="/auth" element={<Login />} />
              <Route path="/dashboard/me" element={<HomePage />} />
          </Routes>
      )
}

export default App
