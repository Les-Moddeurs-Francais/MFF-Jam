package fr.lmf.mffjam.data;

import fr.lmf.mffjam.utils.Utils;
import net.minecraft.data.DataGenerator;

public class MELangProvider extends MeLanguageProvider
{


	private final String LOCALE;

	public MELangProvider(DataGenerator gen, String locale)
	{
		super(gen, Utils.MODID, locale);
		LOCALE = locale;
	}

	@Override
	protected void addTranslations()
	{
		switch ( LOCALE )
		{
			case "en_us":

				break;

			case "fr_fr":

				break;

			default:
				break;
		}
	}
}
