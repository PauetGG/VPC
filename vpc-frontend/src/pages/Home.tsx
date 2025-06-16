import Footer from '../components/Footer';
import Header from '../components/Header';

export default function Home() {
  return (
    <>
      <Header />
      <div className="p-8">
        <h1 className="text-3xl font-bold">Página de inicio</h1>
      </div>
      <Footer />
    </>
  );
}
