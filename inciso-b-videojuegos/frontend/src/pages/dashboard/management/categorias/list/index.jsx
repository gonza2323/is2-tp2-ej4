import { Grid } from '@mantine/core';
import { Page } from '@/components/page';
import { PageHeader } from '@/components/page-header';
import { paths } from '@/routes';
import { CategoriasTable } from './categorias-table';

const breadcrumbs = [
  { label: 'Dashboard', href: paths.dashboard.root },
  { label: 'Management', href: paths.dashboard.management.root },
  { label: 'Categorias', href: paths.dashboard.management.categorias.root },
  { label: 'Lista' },
];

export default function ListCategoriasPage() {
  return (
    <Page title="Lista categorias">
      <PageHeader title="Lista categorias" breadcrumbs={breadcrumbs} />

      <Grid>
        {/* <Grid.Col span={12}>
          <ProveedorMetrics />
        </Grid.Col> */}

        <Grid.Col span={12}>
          <CategoriasTable />
        </Grid.Col>
      </Grid>
    </Page>
  );
}
