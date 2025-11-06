import { Page } from '@/components/page';
import { PageHeader } from '@/components/page-header';
import { paths } from '@/routes';
import CategoriaCreateForm from './categoria-create-form';

const breadcrumbs = [
  { label: 'Dashboard', href: paths.dashboard.root },
  { label: 'Management', href: paths.dashboard.management.root },
  { label: 'Categorias', href: paths.dashboard.management.categorias.root },
  { label: 'Nueva Categoria' },
];

export default function CategoriaCreatePage() {
  return (
    <Page title="Nueva categoria">
      <PageHeader title="Nueva categoria" breadcrumbs={breadcrumbs} />
      <CategoriaCreateForm />
    </Page>
  );
}
