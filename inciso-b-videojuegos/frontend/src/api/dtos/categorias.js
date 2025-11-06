import { z } from 'zod';

export const CategoriaCreateDto = z.object({
  denominacion: z.string().nonempty ("El nombre no puede estar vacío"),
});
