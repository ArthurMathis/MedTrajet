import './App.css'
import { Routes, Route } from 'react-router-dom';
import { Toaster } from 'react-hot-toast';
import Login from "./layouts/pages/Login.tsx";
import HomePage from "./layouts/pages/HomePage.tsx";
import CreationDestinationPage from "./layouts/pages/CreationDestinationPage.tsx";

function App() {
      return (
          <>
              <Toaster position="top-center" />
              <Routes>
                  <Route path="/auth" element={<Login />} />
                  <Route path="/dashboard/me" element={<HomePage />} />
                  <Route path="/destinations/form" element={<CreationDestinationPage />} />
              </Routes>
          </>
      )
}

export default App
